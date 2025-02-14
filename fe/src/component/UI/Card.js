import React from "react";
import styled, { css } from "styled-components";
import StyledDeliveryIcon from "../icons/DeliveryIcon";

const CardImg = styled.img`
  ${({ size }) =>
    size === "small"
      ? css`
          width: 302px;
          height: 302px;
        `
      : size === "xSmall"
      ? css`
          width: 160px;
          height: 160px;
          margin-bottom: 10px;
          margin-right: 6px;
        `
      : css`
          width: 411px;
          height: 411px;
        `}
`;

const CardTitle = styled.h4`
  ${({ size }) =>
    size === "xSmall"
      ? css`
          font-size: ${({ theme }) => theme.fontSize.small};
          margin-bottom: 10px;
        `
      : css`
          font-size: ${({ theme }) => theme.fontSize.medium};
        `}

  margin-top: 5px;
`;

const CardDesc = styled.p`
  font-size: ${({ theme }) => theme.fontSize.medium};
  margin: 5px 0;
  color: #777;
`;

const CardOriginalPrice = styled.span`
  text-decoration: line-through;
  color: ${({ theme }) => theme.colors.grey2};
  font-size: ${({ theme }) => theme.fontSize.small};
  margin-left: 10px;
`;

const CardBadgeWapper = styled.div`
  height: 45px;
  display: flex;
`;

const CardBadge = styled.div`
  height: 30px;
  line-height: 30px;
  border-radius: 20px;
  color: ${({ theme }) => theme.colors.white};
  text-align: center;
  margin-top: 10px;
  margin-right: 10px;
  padding: 0 10px;

  ${({ children }) =>
    children === "런칭특가"
      ? css`
          background: ${({ theme }) => theme.colors.orange};
        `
      : css`
          background: ${({ theme }) => theme.colors.green};
        `}
`;

const CardWrapper = styled.div`
  position: relative;
  margin-right: 18px;
  &:hover {
    .deliveryIconIsActive {
      display: block;
    }
  }
`;

const Card = (props) => {
  return (
    <CardWrapper>
      <CardImg
        src={props.image}
        alt={props.alt}
        size={props.size}
        id={props.id}
        onClick={props.onSaveClickedId}
      />
      <CardTitle size={props.size}>{props.title}</CardTitle>
      <CardDesc>{props.description}</CardDesc>
      <span>{props.s_price}</span>
      <CardOriginalPrice>{props.n_price}</CardOriginalPrice>
      <CardBadgeWapper>
        {!props.badge
          ? ""
          : props.badge.map((v, i) => (
              <CardBadge info={v} key={i}>
                {v}
              </CardBadge>
            ))}
      </CardBadgeWapper>
      <StyledDeliveryIcon
        className={!!props.delivery && "deliveryIconIsActive"}
        size={props.size}
      />
    </CardWrapper>
  );
};

export default Card;
